<header>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse"></button>
			<a class="navbar-brand" href="index.html"> <span> <img
					id="headerLogo"
					src="${pageContext.request.contextPath}/resources/assets/img/webLogo.PNG"
					alt="E-Invoice System Logo">
			</span>
			</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<sec:authorize access="isAuthenticated()">
			    <li><a href="${pageContext.request.contextPath}/logout"> <i
						class="fa fa-fw fa-power-off"></i> Log Out
				</a></li>
			</sec:authorize>
			<c:if test="${user != null}">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-user">${user.name}</i>
				</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/userinfo/${user.id}">
								<i class="fa fa-fw fa-user"></i> Profile
						</a></li>
						<li><a href="#}"> <i class="fa fa-fw fa-envelope"></i>
								Inbox
						</a></li>
						<li><a href="#"> <i class="fa fa-fw fa-gear"></i>
								Settings
						</a></li>
						<li class="divider"></li>
					</ul></li>
			</c:if>

		</ul>
	</nav>
</header>