<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping-Cart</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/ShoppingCart.css">
</head>

<body>
    <div class="top-bar text-center">
        <span>Miễn phí vận chuyển cho đơn hàng từ 1,000,000 ₫</span>
        <span>• Đăng ký tài khoản để được giảm giá -15% cho tất cả các sản phẩm đang thịnh hành</span>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <!-- Logo -->
            <a class="navbar-brand" href="#">
                <img src="https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png" alt="E-Tech Logo">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Giới Thiệu</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            Sản Phẩm
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Điện thoại</a></li>
                            <li><a class="dropdown-item" href="#">Laptop</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Tin Tức</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Liên Hệ</a>
                    </li>
                </ul>

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link nav-icon" href="#"><i class="bi bi-search"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-icon" href="#"><i class="bi bi-person"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-icon" href="#"><i class="bi bi-bag"></i><span
                                class="badge rounded-pill">1</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <!-- Cart Section -->
        <div class="cart-item">
            <div class="cart-item-content">
                <input type="checkbox" aria-label="Checkbox for product">

                <img src="https://images.samsung.com/is/image/samsung/p6pim/vn/2401/gallery/vn-galaxy-s24-490125-sm-s921blbcxxv-539378823?$650_519_PNG$"
                    alt="Samsung Galaxy S24 Ultra">

                <div class="product-details">
                    <p class="product-name">Samsung Galaxy S24 Ultra 12GB 256GB - Vàng</p>
                    <p>
                        <span class="product-price">29.990.000₫</span>
                        <span class="product-old-price">33.990.000₫</span>
                    </p>
                </div>

                <div class="quantity-controls">
                    <button class="btn btn-outline-secondary" type="button">-</button>
                    <input type="text" class="form-control" value="1">
                    <button class="btn btn-outline-secondary" type="button">+</button>
                </div>

                <div class="delete-btn">
                    <i class="bi bi-trash"></i>
                </div>
            </div>
            <div class="cart-item-content">
                <input type="checkbox" aria-label="Checkbox for product">

                <img src="https://images.samsung.com/is/image/samsung/p6pim/vn/2401/gallery/vn-galaxy-s24-490125-sm-s921blbcxxv-539378823?$650_519_PNG$"
                    alt="Samsung Galaxy S24 Ultra">

                <div class="product-details">
                    <p class="product-name">Samsung Galaxy S24 Ultra 12GB 256GB - Vàng</p>
                    <p>
                        <span class="product-price">29.990.000₫</span>
                        <span class="product-old-price">33.990.000₫</span>
                    </p>
                </div>

                <div class="quantity-controls">
                    <button class="btn btn-outline-secondary" type="button">-</button>
                    <input type="text" class="form-control" value="1">
                    <button class="btn btn-outline-secondary" type="button">+</button>
                </div>

                <div class="delete-btn">
                    <i class="bi bi-trash"></i>
                </div>
            </div>
            
            <div class="total-payment mt-4">
                <h5>Tổng cộng: <span id="tong-tien">29.990.000 ₫</span></h5>
                <button class="btn btn-success">Thanh Toán</button>
            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>