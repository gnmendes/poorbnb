<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Poorbnb</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<style>
</style>
<body background="./resources/imagem/bg.png">
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light  shadow">
		<a class="navbar-brand" href="#"> <img
			src="./resources/imagem/logo.png" width="200" height="50" alt="">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#conteudoNavbarSuportado"
			aria-controls="conteudoNavbarSuportado" aria-expanded="false"
			aria-label="Alterna navega��o">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">P�gina
						inicial <span class="sr-only">(p�gina atual)</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Sobre</a></li>

				<li class="nav-item"><a class="nav-link" href="#">Anuncie
						seu hotel</a></li>

			</ul>
			<form class="form-inline my-2 my-lg-0">

				<div class="btn-group " role="group" aria-label="Exemplo b�sico">
					<button type="button" class="btn btn-warning">Cadastrar</button>
					<button type="button" class="btn btn-warning">Entrar</button>
				</div>
			</form>
		</div>
	</nav>


	<!-- Fim navbar -->
	<!-- Cadastro -->
	<p></p>
	<div class="container d-flex justify-content-center">

		<div class="card">
			<article class="card-body">
				<h4 class="card-title text-center mb-4 mt-1">Cadastrar hotel</h4>
				<hr>
				<p class="text-success text-center">
					<img src="./resources/imagem/logo-2.png" width="94" height="86"
						alt="" id="centro">
				</p>
				<form>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-user"></i>
								</span>
							</div>
							<input name="" class="form-control" placeholder="Nome hotel"
								type="text">
						</div>
						<!-- email// -->
						<p></p>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fa fa-envelope"></i>
									</span>
								</div>
								<input name="" class="form-control" placeholder="Email"
									type="text">
							</div>
							<!-- email// -->
							<p></p>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i
											class="fa fa-pencil-square-o"></i>
										</span>
									</div>
									<input name="" class="form-control" placeholder="CNPJ"
										type="text">
								</div>
								<!-- CPF// -->

							</div>
							<!-- form-group// -->
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="fa fa-lock"></i>
										</span>
									</div>
									<input class="form-control" placeholder="Digite a senha"
										type="password"> <input class="form-control"
										placeholder="Confirme a senha" type="password">
								</div>
								<!-- senha// -->



								<p></p>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i class="fa fa-user"></i>
											</span>
										</div>
										<input name="" class="form-control"
											placeholder="fa fa-map-marker" type="text">
									</div>
									<!-- Endereco// -->


									<p></p>
									<div class="form-group">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="fa fa-phone"></i>
												</span>
											</div>
											<input name="" class="form-control" placeholder="Telefone"
												type="text"> <input name="" class="form-control"
												placeholder="Telefone 2" type="text">
										</div>
										<!-- Endereco// -->
									</div>
									<!-- form-group// -->
									<div class="form-group">
										<button type="submit" class="btn btn-warning btn-block">
											Pr�ximo <i class="fa fa-arrow-right" aria-hidden="true"></i>
										</button>
									</div>
									<!-- form-group// -->
									<p class="text-center">
										<a href="#" class="btn">Voltar para a p�gina principal</a>
									</p>
				</form>
			</article>
		</div>
		<!-- card.// -->
</body>
</html>