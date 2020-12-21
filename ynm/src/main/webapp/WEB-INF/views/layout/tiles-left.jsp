<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!-- left page -->

    <div class="left">
	    <c:forEach items="${list}" var="item">
	    	<div>
           <c:choose>
            <c:when test="${item.PARENT_IDX != null}">
                <ul>
                    <li group="${item.PARENT_IDX}" class="item">
                        <a href="<c:url value='/board/${item.IDX}'/>">${item.TITLE}</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
	                 <div class="mtitle">
                        <a href="#" id="btn_${item.IDX}"  onclick="sideBarClick(${item.IDX})">${item.TITLE}
                               <i class="fa fa-plus"></i>
                       	</a>
	                 </div>
            </c:otherwise>
           </c:choose>
	      
          </div>
	   	</c:forEach>
    </div>
    
<script src="<c:url value='/resources/js/board/boardLs.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/user/userLogin.js'/>" charset="utf-8"></script>
<!-- left page -->