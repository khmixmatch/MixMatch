package com.kh.mixmatch.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.kh.mixmatch.notice.domain.NoticeCommand;
import com.kh.mixmatch.notice.domain.NoticeReplyCommand;
@Transactional
public interface NoticeService {
	public void noticeInsert(NoticeCommand notice);
	public void noticeDelete(Integer gn_seq);
	public void noticeUpdate(NoticeCommand notice);
	public void noticeUpdateHit(Integer gn_seq);
	@Transactional(readOnly=true)
	public NoticeCommand noticeSelect(Integer gn_seq);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	@Transactional(readOnly=true)
	public List<NoticeCommand> noticeList(Map<String, Object> map);
	
	//댓글
	public void insertReply(NoticeReplyCommand noticeReplyCommand);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public List<NoticeReplyCommand> listReply(Map<String,Object> map);
	public void updateReply(NoticeReplyCommand noticeReplyCommand);
	public void deleteReply(Integer gnre_no);
}
