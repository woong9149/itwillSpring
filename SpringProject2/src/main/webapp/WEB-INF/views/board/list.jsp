<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// BoardDAO bdao 객체생성
// BoardDAO bdao=new BoardDAO();
// 게시판 전체 글 개수  getBoardCount() 만들고 호출  count(*) 
// int count=bdao.getBoardCount();   
// 한화면에 보여줄 글개수 설정
int pageSize=3;
//페이지번호 가져오기
String pageNum=request.getParameter("pageNum");
// 페이지번호를 안 가지고온 경우 => 무조건 1페이지 
if(pageNum==null){
	pageNum="1";
}
int currentPage=Integer.parseInt(pageNum);
// currentPage  pageSize 이용  가져올 글의 시작행 구하기
//    1        10      => 1-1 *10 +1 => 0  + 1  => 1 행
//    2        10      => 2-1 *10 +1 => 10 + 1  => 11행
//    3        10      => 3-1 *10 +1 => 20 + 1  => 21행
int startRow=(currentPage-1)*pageSize+1;
// currentPage  pageSize 이용  가져올 글의 끝행 구하기
//     1           10    => 10행
//     2           10    => 20행
//     3           10    => 30행
int endRow =currentPage*pageSize;

// List boardList = getBoardList() 메서드 만들어서 호출
//List boardList=bdao.getBoardList();
//List boardList=bdao.getBoardList(시작행,글개수); 
// 시작행 부터 글개수 만큼 글 가져오기 1행부터 10개   11행부터 10개 
// List boardList=bdao.getBoardList(startRow, pageSize);
%>
<h1>WebContent/board/list.jsp</h1>
<h1>글목록[전체글개수 : <%//=count %>]</h1>
<h3><a href="writeForm.jsp">게시판글쓰기</a></h3>
<table border="1">
<tr><td>번호</td><td>제목</td><td>작성자</td><td>날짜</td><td>조회수</td></tr>
<%
//5단계 for 다음행이동 num subject name date  readcount 출력
// for(int i=0;i<boardList.size();i++){
// 	BoardBean bb=(BoardBean)boardList.get(i);
	%>
<tr><td><%//=bb.getNum() %></td>
<td><a href="content.jsp?num=<%//=bb.getNum()%>"><%//=bb.getSubject() %></a></td>
<td><%//=bb.getName() %></td><td><%//=bb.getDate() %></td>
    <td><%//=bb.getReadcount() %></td></tr>	
	<%
// }
%>
</table>
<%
// if(count!=0){
	// 게시판 전체 페이지 수 구하기
	// 글개수count 50개 글  한화면에 보여줄 글개수 10개 => 5 +0 =>5 페이지
	// 글개수count 56개 글  한화면에 보여줄 글개수 10개 => 5 +1 =>6 페이지
// 	int pageCount=count/pageSize+(count%pageSize==0?0:1);
	// 한화면에 보여줄 페이지수 
	int pageBlock=3;
	// 시작하는 페이지 번호 구하기 1~10 => 1  11~20 => 11
	// currentPage 1~10  pageBlock 10  =>  (1~10-1)/10 * 10 +1 => 0+1=>1
	// currentPage 11~20  pageBlock 10  =>  (11~20-1)/10 * 10 +1=> 10+1=>11
	// currentPage 21~30  pageBlock 10  =>  (21~30-1)/10 * 10 +1=> 20+1=>21
	int startPage=((currentPage-1)/pageBlock)*pageBlock+1;
	// 끝나는 페이지 번호 구하기  1~10 => 10  11~20 => 20
	// startPage   pageBlock   =>  endPage
	//    1            10       =>   10
	//    11           10       =>   20
	//    21           10       =>   30  
	int endPage=startPage+pageBlock-1;
	// 계산결과 10 실제페이지수 2 경우 => endPage 2로 변경
// 	if(endPage > pageCount){
// 		endPage=pageCount;
// 	}
	//[이전] startPage 1아니고 11부터 [이전]글자 보이기
	if(startPage > pageBlock){
		%><a href="list.jsp?pageNum=<%=startPage-pageBlock%>">[이전]</a><%
	}
	// 출력 [1][2][3]....[10]
	for(int i=startPage;i<=endPage;i++){
		%><a href="list.jsp?pageNum=<%=i%>">[<%=i %>]</a><%
	}
	//[다음] endPage보다 pageCount 가 더크면
// 	if(endPage < pageCount){
		%><a href="list.jsp?pageNum=<%=startPage+pageBlock%>">[다음]</a><%
// 	}
// }
%>
<!--       [1][2][3]....[10][다음] -->
<!-- [이전][11][12][13]....[20][다음] -->
</body>
</html>





