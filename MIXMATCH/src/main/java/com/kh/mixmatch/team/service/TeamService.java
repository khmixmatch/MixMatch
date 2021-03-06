package com.kh.mixmatch.team.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.kh.mixmatch.match.domain.MatchCommand;
import com.kh.mixmatch.team.domain.TeamCommand;
@Transactional
public interface TeamService {
	@Transactional(readOnly=true)
	public List<TeamCommand> list(Map<String, Object> map);
	
	public void insertTeam(TeamCommand team);
	
	@Transactional(readOnly=true)
	public int getTeamCount(Map<String, Object> map);
	
	@Transactional(readOnly=true)
	public TeamCommand selectTeam(String tname);
	
	public void updateTeam(TeamCommand team);
	
	public void deleteTeam(String tname);
	public void updateDelTeam(TeamCommand team);
	@Transactional(readOnly=true)
	public List<TeamCommand> listRank(Map<String, Object> map);
	@Transactional(readOnly=true)
	public List<TeamCommand> listMaster(String id);
	@Transactional(readOnly=true)
	public int countMasterTeam(String id);
	// 매치 service
	@Transactional(readOnly=true)
	public List<MatchCommand> listMatch(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int countHomeMatch(String tname);
	@Transactional(readOnly=true)
	public int countAwayMatch(String tname);
	@Transactional(readOnly=true)
	public MatchCommand selectMatchDetail(Integer mseq);
	@Transactional(readOnly=true)
	public List<MatchCommand> matchListFinish(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int MainmatchCountFinish(Map<String, Object> map);
}
