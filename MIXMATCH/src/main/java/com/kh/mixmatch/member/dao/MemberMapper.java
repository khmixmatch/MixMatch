package com.kh.mixmatch.member.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.mixmatch.member.domain.MemberCommand;

public interface MemberMapper {
	@Insert("INSERT INTO g_member (id,pw,name,birth,phone,email,favor,regdate,address,profile_name,profile) "
			+ "VALUES(#{id},#{pw},#{name},#{birth},#{phone},#{email},#{favor},sysdate,#{address},#{profile_name,jdbcType=VARCHAR},#{profile,jdbcType=BLOB})")
	public void insertMember(MemberCommand member);
	@Select("SELECT * FROM g_member WHERE id=#{id}")
	public MemberCommand selectMember(String id);
	@Update("UPDATE g_member SET name=#{name},phone=#{phone},email=#{email},favor=#{favor},address=#{address},"
			+ "profile_name=#{profile_name,jdbcType=VARCHAR},profile=#{profile,jdbcType=BLOB} WHERE id=#{id}")
	public void updateMember(MemberCommand member);
	@Update("UPDATE g_member SET pw=#{changePw} WHERE id=#{id}")
	public void updatePw(MemberCommand member);
	@Update("UPDATE g_member SET status='N' WHERE id=#{id}")
	public void deleteMember(String id);
	
	//등급수정
	@Update("UPDATE g_member SET auth='Silver' WHERE point >= 10000 ")
	public void silverUpdate();
	@Update("UPDATE g_member SET auth='Gold' WHERE point >= 20000 ")
	public void goldUpdate();
	@Update("UPDATE g_member SET auth='Platinum' WHERE point >= 30000 ")
	public void platinumUpdate();
	@Update("UPDATE g_member SET auth='Diamond' WHERE point >= 40000 ")
	public void diamondUpdate();
	
	//상위 1위회원 검색
	@Select("SELECT * FROM(SELECT * FROM g_member ORDER BY point DESC) WHERE rownum <= 1")
	public MemberCommand todayMember();
	//상위 1위회원에게 포인트 추가 적립
	@Update("UPDATE g_member SET point = point+500 WHERE id=#{id}")
	public void todayMemberPointUpdate(String id);
}
