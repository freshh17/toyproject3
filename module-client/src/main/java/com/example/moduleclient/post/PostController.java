package com.example.moduleclient.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.moduleclient.constant.Category;
import com.example.modulecore.util.ApiUtil;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	private final PostService postService;

	@GetMapping("/boards")
	public String list(
		@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
		@AuthenticationPrincipal UserDetails userDetails, Model model,
		@PageableDefault(size = 6, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<PostPagesDto> postPages = postService.list(pageNo, Category.GENERAL, pageable);
		model.addAttribute("list", postPages);

		return "board/list";
	}

	@GetMapping("/board/save")
	public String saveForm() {
		return "/board/save";
	}

	@PutMapping("/insert")
	@ResponseBody
	//@TODO: UserDetails 가져오기
	public ResponseEntity<?> savePost(@RequestBody PostRequest.saveDto saveDto) {
		PostResponse.SaveDto saveRespDto = postService.savePost(saveDto, 1L);
		return ResponseEntity.ok().body(ApiUtil.success(saveRespDto));
	}

	@DeleteMapping("/boards/{id}/delete")
	@ResponseBody
	public ResponseEntity<?> deletePost(@PathVariable Long id) {
		PostResponse.DeleteDto deleteRespDto = postService.deletePost(id);
		return ResponseEntity.ok().body(ApiUtil.success(deleteRespDto));
	}

	@PostMapping("/boards/{id}/update")
	@ResponseBody
	public ResponseEntity<?> updatePost(@RequestBody PostRequest.updateDto updateReqDto, @PathVariable Long id) {
		PostResponse.UpdateDto updateRespDto = postService.updatePost(updateReqDto, id);

		return ResponseEntity.ok().body(ApiUtil.success(updateRespDto));
	}

	@GetMapping("/boards/search")
	@ResponseBody
	public ResponseEntity<?> searchPosts(@RequestParam int gubun, @RequestParam String keyword) {
		Page<PostPagesDto> postPages = postService.searchByKeyword(0, gubun, keyword);
		return ResponseEntity.ok().body(ApiUtil.success(postPages));
	}
}
