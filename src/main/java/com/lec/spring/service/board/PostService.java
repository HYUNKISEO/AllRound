package com.lec.spring.service.board;

import com.lec.spring.domain.Dto.PostDto;
import com.lec.spring.domain.board.Post;
import com.lec.spring.repository.board.PostRepository;
import com.lec.spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post save (PostDto post) {
        Post savePost = new Post();
        savePost.setSubject(post.getSubject());
        savePost.setContents(post.getContent());
        savePost.setCategory(post.getCategory());
        savePost.setViewCnt(0L);
        savePost.setUser(userRepository.findById(post.getUserId()).orElse(null));

        return postRepository.save(savePost);
    }

    public Post update (PostDto post) {
        Post savePost = new Post();
        savePost.setId(post.getId());
        savePost.setSubject(post.getSubject());
        savePost.setContents(post.getContent());
        savePost.setCategory(post.getCategory());
        savePost.setViewCnt(post.getViewCnt());
        savePost.setUser(userRepository.findById(post.getUserId()).orElse(null));

        return postRepository.save(savePost);
    }

    public PostDto update (Long id) {
        Post post = postRepository.findById(id).orElse(null);
        PostDto mainPost = new PostDto();
        mainPost.setId(post.getId());
        mainPost.setCategory(post.getCategory());
        mainPost.setContent(post.getContents());
        mainPost.setSubject(post.getSubject());
        mainPost.setUsername(post.getUser().getUsername());
        mainPost.setViewCnt(post.getViewCnt());
        mainPost.setCreateTime(post.getCreateTime());
        mainPost.setUserId(post.getUser().getId());

        return mainPost;
    }

    @Transactional
    public PostDto findById (Long id) {

        Post post = postRepository.findById(id).orElse(null);
        post.setViewCnt(post.getViewCnt() + 1L);
        postRepository.save(post);

        PostDto mainPost = new PostDto();
        mainPost.setId(post.getId());
        mainPost.setCategory(post.getCategory());
        mainPost.setContent(post.getContents());
        mainPost.setSubject(post.getSubject());
        mainPost.setUsername(post.getUser().getUsername());
        mainPost.setViewCnt(post.getViewCnt());
        mainPost.setCreateTime(post.getCreateTime());
        mainPost.setUserId(post.getUser().getId());

        return mainPost;
    }

    public List<PostDto> findAll (int pageNumber, int pageSize, String sort) {

        Sort sorting ;
        if("조회순".equals(sort)){
            sorting = Sort.by(Sort.Order.desc("viewCnt"));
        } else {
            sorting = Sort.by(Sort.Order.desc("id"));
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sorting);

        Page<Post> postPage;
        if ("일반".equals(sort) || "질문".equals(sort) || "스터디".equals(sort)) {
            // sort 값이 "일반", "질문", "스터디" 중 하나인 경우 해당 카테고리에 따라 필터링
            postPage = postRepository.findByCategory(sort, pageable);
        } else {
            // 기본 케이스: 특정 카테고리 필터링 없음
            postPage = postRepository.findAll(pageable);
        }

        List<PostDto> postDtoList = postPage.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        // 전체 엘리먼트 수를 PostDto의 totalCount에 할당
        long totalCount = postPage.getTotalElements();
        postDtoList.forEach(postDto -> postDto.setTotalCount(totalCount));

        return postDtoList;
    }

    private PostDto convertToDTO(Post post) {
        // Post를 PostDto로 매핑하는 로직을 작성
        return new PostDto(post.getId(), post.getSubject(), post.getContents(), post.getCategory(),
                post.getViewCnt(), post.getUser().getId(), post.getUser().getUsername(), 0L, post.getCreateTime());
    }

    public String delete (Long id) {
        if(id != null) {
            postRepository.deleteById(id);
            return "1";
        }else {
            return "0";
        }
    }

    public List<PostDto> findByUserId(Long userId) {
        List<Post> userPosts = postRepository.findByUserId(userId);
        List<PostDto> postDtoList = userPosts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return postDtoList;
    }

    public List<Post> findAll() {
        return postRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }
}
