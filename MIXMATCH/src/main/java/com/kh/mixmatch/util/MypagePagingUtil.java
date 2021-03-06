/*******************************************************************************
 * ���ϸ� : PagingUtil.java
 * �ۼ��� : ��븸
 * �ۼ����� : 2013. 01. 01
 *
 * Ŭ���� ����: ����¡
 * =============================================================================
 * ��������
 * NO   ��������			������		��������  
 * 001. 2013. 01. 01	��븸  		�����ۼ�
 * 002. 2013. 05. 15    ��븸          �پ��� ���ڸ� ó���� �� �ֵ��� ������ �߰�
 * 003. 2014. 01. 02    ��븸          �˻��� url ���� ���� ����
 * =============================================================================
 */
package com.kh.mixmatch.util;

public class MypagePagingUtil {
	private int startCount;	 // �� ���������� ������ �Խñ��� ���� ��ȣ
	private int endCount;	 // �� ���������� ������ �Խñ��� �� ��ȣ
	private StringBuffer pagingHtml;// ������ ǥ�� ���ڿ�
  
	/**
	 * currentPage : ����������
	 * totalCount : ��ü �Խù� ��
	 * rowCount : �� ��������  �Խù��� ��
	 * pageCount : �� ȭ�鿡 ������ ������ ��
	 * pageUrl : ȣ�� ������ url
	 * addKey : �ΰ����� key ���� ���� null ó�� (&num=23�������� ������ ��)
	 * */
	public MypagePagingUtil(int currentPage, int totalCount, int rowCount, int pageCount, String pageUrl) {
		this(null,null,currentPage,totalCount,rowCount,pageCount,pageUrl,null);
	}
	public MypagePagingUtil(int currentPage, int totalCount, int rowCount, int pageCount, String pageUrl, String addKey) {
		this(null,null,currentPage,totalCount,rowCount,pageCount,pageUrl,addKey);
	}
	public MypagePagingUtil(String keyfield, String keyword, int currentPage, int totalCount, int rowCount, int pageCount,String pageUrl) {
		this(keyfield,keyword,currentPage,totalCount,rowCount,pageCount,pageUrl,null);
	}
	public MypagePagingUtil(String keyfield, String keyword, int currentPage, int totalCount, int rowCount, int pageCount,String pageUrl,String addKey) {
		
		if(addKey == null) addKey = ""; //�ΰ�Ű�� null �϶� ""ó��
		
		// ��ü ������ ��
		int totalPage = (int) Math.ceil((double) totalCount / rowCount);
		if (totalPage == 0) {
			totalPage = 1;
		}
		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}
		// ���� �������� ó���� ������ ���� ��ȣ ��������.
		startCount = (currentPage - 1) * rowCount + 1;
		endCount = currentPage * rowCount;
		// ���� �������� ������ ������ �� ���ϱ�.
		int startPage = (int) ((currentPage - 1) / pageCount) * pageCount + 1;
		int endPage = startPage + pageCount - 1;
		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		// ���� block ������
		pagingHtml = new StringBuffer();
		if (currentPage > pageCount) {
			if(keyword==null){//�˻� �̻���
				pagingHtml.append("<a href="+pageUrl+"?pageNum="+ (startPage - 1) + addKey +">");
			}else{
				pagingHtml.append("<a href="+pageUrl+"?keyfield="+keyfield+"&keyword="+keyword+"&pageNum="+ (startPage - 1) + addKey +">");
			}
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
		pagingHtml.append("&nbsp;|&nbsp;");
		//������ ��ȣ.���� �������� ���������� �����ϰ� ��ũ�� ����.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("&nbsp;<b> <font color='red'>");
				pagingHtml.append(i);
				pagingHtml.append("</font></b>");
			} else {
				if(keyword==null){//�˻� �̻���
					pagingHtml.append("&nbsp;<a href='"+pageUrl+"&pageNum=");
				}else{
					pagingHtml.append("&nbsp;<a href='"+pageUrl+"?keyfield="+keyfield+"&keyword="+keyword+"&pageNum=");
				}
				pagingHtml.append(i);
				pagingHtml.append(addKey+"'>");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp;");
		}
		pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
		// ���� block ������
		if (totalPage - startPage >= pageCount) {
			if(keyword==null){//�˻� �̻���
				pagingHtml.append("<a href="+pageUrl+"?pageNum="+ (endPage + 1) + addKey +">");
			}else{
				pagingHtml.append("<a href="+pageUrl+"?keyfield="+keyfield+"&keyword="+keyword+"&pageNum="+ (endPage + 1) + addKey +">");
			}
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}
	}
	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}
	public int getStartCount() {
		return startCount;
	}
	public int getEndCount() {
		return endCount;
	}

}
