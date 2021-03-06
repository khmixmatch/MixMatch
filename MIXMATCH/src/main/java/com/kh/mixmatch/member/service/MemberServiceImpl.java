package com.kh.mixmatch.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kh.mixmatch.member.dao.MemberMapper;
import com.kh.mixmatch.member.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Resource
	private MemberMapper memberMapper;
	
	@Override
	public void insertMember(MemberCommand member) {
		memberMapper.insertMember(member);
	}

	@Override
	public MemberCommand selectMember(String id) {
		return memberMapper.selectMember(id);
	}

	@Override
	public void updateMember(MemberCommand member) {
		memberMapper.updateMember(member);
	}

	@Override
	public void updatePw(MemberCommand member) {
		memberMapper.updatePw(member);
	}
	
	@Override
	public void deleteMember(String id) {
		memberMapper.deleteMember(id);
	}

	@Override
	public void silverUpdate() {
		memberMapper.silverUpdate();
	}

	@Override
	public void goldUpdate() {
		memberMapper.goldUpdate();
	}

	@Override
	public void platinumUpdate() {
		memberMapper.platinumUpdate();
	}

	@Override
	public void diamondUpdate() {
		memberMapper.diamondUpdate();
	}

	@Override
	public MemberCommand todayMember() {
		return memberMapper.todayMember();
	}

	@Override
	public void todayMemberPointUpdate(String id) {
		memberMapper.todayMemberPointUpdate(id);
	}
	
}
