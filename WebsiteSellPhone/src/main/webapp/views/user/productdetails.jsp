<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="vi-VN">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Product Details</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
	<link rel="stylesheet" type="text/css"
		href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
	<link rel="stylesheet" href="//assets/user/css/style.css" /> <!-- Link đến CSS tùy chỉnh nếu có -->
</head>

<body>
	<div class="pd-wrap">
		<div class="container">
			<div class="heading-section">
				<h2>Product Details</h2>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div id="slider" class="owl-carousel product-slider">
						<div class="item">
							<img
								src="https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80" />
						</div>
						<div class="item">
							<img src="https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg" />
						</div>
						<div class="item">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw" />
						</div>
						<div class="item">
							<img src="https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg" />
						</div>
						<div class="item">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw" />
						</div>
						<div class="item">
							<img src="https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg" />
						</div>
						<div class="item">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw" />
						</div>
					</div>
					<div id="thumb" class="owl-carousel product-thumb">
						<div class="item">
							<img
								src="https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80" />
						</div>
						<div class="item">
							<img src="https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg" />
						</div>
						<div class="item">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw" />
						</div>
						<div class="item">
							<img src="https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg" />
						</div>
						<div class="item">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw" />
						</div>
						<div class="item">
							<img src="https://i.ytimg.com/vi/PJ_zomNMK_s/maxresdefault.jpg" />
						</div>
						<div class="item">
							<img
								src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQI6nUmObt62eDkqNSmIvCN_KkQExtbpJmUbVx_eTh_Y3v3r-Jw" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="product-dtl">
						<div class="product-info">
							<div class="product-name">Tên sản phẩm</div>
							<div class="reviews-counter">
								<div class="rate">
									<input type="radio" id="star5" name="rate" value="5" checked />
									<label for="star5" title="text">5 stars</label>
									<input type="radio" id="star4" name="rate" value="4" checked />
									<label for="star4" title="text">4 stars</label>
									<input type="radio" id="star3" name="rate" value="3" checked />
									<label for="star3" title="text">3 stars</label>
									<input type="radio" id="star2" name="rate" value="2" />
									<label for="star2" title="text">2 stars</label>
									<input type="radio" id="star1" name="rate" value="1" />
									<label for="star1" title="text">1 star</label>
								</div>
								<span>3 Reviews</span>
							</div>
							<div class="product-price-discount"><span>$39.00</span><span
									class="line-through">$29.00</span></div>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
							labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
							laboris nisi ut aliquip ex ea commodo consequat.</p>
						<div class="row">
							<div class="col-md-6">
								<label for="size">Dung lượng bộ nhớ</label>
								<select id="size" name="size" class="form-control">
									<option>64GB</option>
									<option>128GB</option>
									<option>256GB</option>
									<option>1T</option>
								</select>
							</div>
							<div class="col-md-6">
								<label for="color">Màu sắc</label>
								<select id="color" name="color" class="form-control">
									<option>Blue</option>
									<option>Green</option>
									<option>Red</option>
								</select>
							</div>
						</div>
						<div class="product-count">
							<label for="size">Số lượng</label>
							<form action="#" class="display-flex">
								<div class="qtyminus">-</div>
								<input type="text" name="quantity" value="1" class="qty">
								<div class="qtyplus">+</div>
							</form>
							<a href="#" class="round-black-btn">Thêm vào giỏ hàng</a>
						</div>
					</div>
				</div>
			</div>
			<div class="product-info-tabs">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item">
						<a class="nav-link active" id="description-tab" data-toggle="tab" href="#description" role="tab"
							aria-controls="description" aria-selected="true">Description</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" id="review-tab" data-toggle="tab" href="#review" role="tab"
							aria-controls="review" aria-selected="false">Reviews (0)</a>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="description" role="tabpanel"
						aria-labelledby="description-tab"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
						nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
						dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur
						sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est
						laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
						laudantium, totam rem aperiam. </div>
					<div class="tab-pane fade" id="review" role="tabpanel" aria-labelledby="review-tab">
						<div class="review-heading">REVIEWS</div>
						<p class="mb-20">There are no reviews yet.</p>
						<form class="review-form">
							<div class="form-group"> <label>Your rating</label>
								<div class="reviews-counter">
									<div class="rate"> <input type="radio" id="star5" name="rate" value="5" /> <label
											for="star5" title="text">5 stars</label> <input type="radio" id="star4"
											name="rate" value="4" /> <label for="star4" title="text">4 stars</label>
										<input type="radio" id="star3" name="rate" value="3" /> <label for="star3"
											title="text">3 stars</label> <input type="radio" id="star2" name="rate"
											value="2" /> <label for="star2" title="text">2 stars</label> <input
											type="radio" id="star1" name="rate" value="1" /> <label for="star1"
											title="text">1 star</label> </div>
								</div>
							</div>
							<div class="form-group"> <label>Your message</label> <textarea class="form-control"
									rows="10"></textarea> </div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group"> <input type="text" name="" class="form-control"
											placeholder="Name*"> </div>
								</div>
								<div class="col-md-6">
									<div class="form-group"> <input type="text" name="" class="form-control"
											placeholder="Email Id*"> </div>
								</div>
							</div> <button class="round-black-btn">Submit Review</button>
						</form>
					</div>
				</div>
			</div>
			<div style="text-align:center;font-size:14px;padding-bottom:20px;"> Get free icon packs for your next
				project at <a href="http://iiicons.in/" target="_blank"
					style="color:#ff5e63;font-weight:bold;">www.iiicons.in</a> </div>
		</div>
	</div>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
	<script src="//assets/user/js/style.js"></script> <!-- Link đến JS tùy chỉnh nếu có -->

</body>

</html>