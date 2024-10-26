<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/user/css/product.css">
</head>
<body>
  <div class="lightbox-blanket">
    <div class="pop-up-container">
      <div class="pop-up-container-vertical">
        <div class="pop-up-wrapper">
          <div class="go-back" onclick="GoBack();"><i class="fa fa-arrow-left"></i>
          </div>
          <div class="product-details">
            <div class="product-left">
              <div class="product-info">
                <div class="product-manufacturer">NOOK
                </div>
                <div class="product-title">
                  LOUNGE CHAIR
                </div>
                <div class="product-price" price-data="320.03">
                  $320<span class="product-price-cents">03</span>
                </div>
              </div>
              <div class="product-image">
                <img src="https://via.placeholder.com/300" />
              </div>
            </div>
            <div class="product-right">
              <div class="product-description">
                Designer Karim Rashid continues to put his signature spin on all genres of design through various collaborations with top-notch companies. Another one to add to the win column is his work with Italian manufacturer Chateau d’Ax.
              </div>
              <div class="product-available">
                In stock. <span class="product-extended"><a href="#">Buy Extended Warranty</a></span>
              </div>
              <div class="product-rating">
                <i class="fa fa-star rating" star-data="1"></i>
                <i class="fa fa-star rating" star-data="2"></i>
                <i class="fa fa-star rating" star-data="3"></i>
                <i class="fa fa-star" star-data="4"></i>
                <i class="fa fa-star" star-data="5"></i>
                <div class="product-rating-details">(3.1 - <span class="rating-count">1203</span> reviews)
                </div>

              </div>
              <div class="product-quantity">
                <label for="product-quantity-input" class="product-quantity-label">Quantity</label>
                <div class="product-quantity-subtract">
                  <i class="fa fa-chevron-left"></i>
                </div>
                <div>
                  <input type="text" id="product-quantity-input" placeholder="0" value="0" />
                </div>
                <div class="product-quantity-add">
                  <i class="fa fa-chevron-right"></i>
                </div>
              </div>
            </div>
            <div class="product-bottom">
              <div class="product-checkout">
                Total Price
                <div class="product-checkout-total">
                  <i class="fa fa-usd"></i>
                  <div class="product-checkout-total-amount">
                    0.00
                  </div>
                </div>
              </div>
              <div class="product-checkout-actions">
                <a class="add-to-cart" href="#" onclick="AddToCart(event);">Add to Cart</a>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="random-background">
    <div class="itemlist">
      <div class="itemlist-item-wrapper" onclick="OpenProduct(1);">
        <div class="product-details">
          <div class="">
            <div class="product-info">

              <div class="product-title" item-data="1">
                LOUNGE CHAIR
              </div>
              <div class="product-price" price-data="320.03" item-data="1">
                $320<span class="product-price-cents">03</span>
              </div>
            </div>
            <div class="product-image" item-data="1">
              <img src="https://via.placeholder.com/300" />
            </div>
          </div>
        </div>
      </div>
      <div class="itemlist-item-wrapper" onclick="OpenProduct(2);">
        <div class="product-details">
          <div class="">
            <div class="product-info">

              <div class="product-title" item-data="2">
                LOUNGE CHAIR
              </div>
              <div class="product-price" price-data="320.03" item-data="2">
                $320<span class="product-price-cents">03</span>
              </div>
            </div>
            <div class="product-image" item-data="2">
              <img src="https://via.placeholder.com/300" />
            </div>
          </div>
        </div>
      </div>
      <div class="itemlist-item-wrapper" onclick="OpenProduct(3);">
        <div class="product-details">
          <div class="">
            <div class="product-info">

              <div class="product-title" item-data="3">
                LOUNGE CHAIR
              </div>
              <div class="product-price" price-data="320.03" item-data="3">
                $320<span class="product-price-cents">03</span>
              </div>
            </div>
            <div class="product-image" item-data="3">
              <img src="https://via.placeholder.com/300" />
            </div>
          </div>
        </div>
      </div>
      <div class="itemlist-item-wrapper" onclick="OpenProduct(4);">
        <div class="product-details">
          <div class="">
            <div class="product-info">
              <div class="product-title" item-data="4">
                LOUNGE CHAIR
              </div>
              <div class="product-price" price-data="320.03" item-data="4">
                $320<span class="product-price-cents">03</span>
              </div>
            </div>
            <div class="product-image" item-data="4">
              <img src="https://via.placeholder.com/300" />
            </div>
          </div>
        </div>
      </div>
      <div class="itemlist-item-wrapper" onclick="OpenProduct(5);">
        <div class="product-details">
          <div class="">
            <div class="product-info">
              <div class="product-title" item-data="5">
                LOUNGE CHAIR
              </div>
              <div class="product-price" price-data="169.49" item-data="5">
                $<span class="product-price-dollar">169</span><span class="product-price-cents">49</span>
              </div>
            </div>
            <div class="product-image" item-data="5">
              <img src="https://via.placeholder.com/300" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<script src="${pageContext.request.contextPath}/assets/user/js/product.js"></script>
</html>