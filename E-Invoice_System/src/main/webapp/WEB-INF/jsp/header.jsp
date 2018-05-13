<header>
		<div class="header-col header-logo">
			<a class="" href="${pageContext.request.contextPath}">
			 <img
					class="logoImage"
					src="${pageContext.request.contextPath}/resources/assets/img/webLogo.png"
					alt="E-Invoice System Logo">
			</a>
		</div>
		<!-- Top Menu Items -->
		<div class="header-col header-space">
		</div>
		
		<div class="header-col header-account-control">
		<ul>
			<sec:authorize access="isAuthenticated()">
				<li><a href="${pageContext.request.contextPath}/logout">
						Log Out </a></li>
			</sec:authorize>
			<c:if test="${isAdmin != true}">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i>${user.name}</i>
				</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/userinfo">
								Profile </a></li>
						<li class="divider"></li>
					</ul></li>
			</c:if>
			<c:if test="${isAdmin == true}">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i>${pageContext.request.userPrincipal.name}</i>
				</a>
			</c:if>
		</ul>

	</div>
</header>