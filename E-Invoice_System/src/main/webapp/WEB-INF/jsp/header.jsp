<header>
		<div class="header-col header-logo">
			<a class="" href="${pageContext.request.contextPath}">
			 <img
					class="logoImage"
					src="${pageContext.request.contextPath}/resources/assets/img/webLogo.PNG"
					alt="E-Invoice System Logo">
			</a>
		</div>
		<!-- Top Menu Items -->
		<div class="header-col header-space">
		</div>
		<sec:authorize access="isAuthenticated()">
		<div class="header-col header-account-control">
		<ul>
			
				<li><a href="${pageContext.request.contextPath}/logout" class="btn btn-default btn-sm btn-header">
          			<span class="glyphicon glyphicon-log-out"></span> Log out
       			 </a></li>
						
			<c:if test="${isAdmin != true}">
				<li class="dropdown"><a href="#" class="dropdown-toggle btn btn-default btn-sm btn-header"
					data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span><i> ${user.name}</i> </a>
				</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/userinfo">
								Profile </a></li>
					</ul></li>
			</c:if>
			<c:if test="${isAdmin == true}">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i>${pageContext.request.userPrincipal.name}</i>
				</a>
			</c:if>
		</ul>

	</div>
	</sec:authorize>
</header>