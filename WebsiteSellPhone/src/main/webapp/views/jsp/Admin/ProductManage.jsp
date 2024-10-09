<%--
  Created by IntelliJ IDEA.
  User: buiquangthuc
  Date: 9/10/24
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Manage</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
  <script src="https://kit.fontawesome.com/27e6f9e8b6.js" crossorigin="anonymous"></script>
  <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/Admin.css">

</head>

<body>
<div class="container-fluid">
  <div class="row">
    <div class="wrapper">
      <aside id="sidebar">
        <div class="d-flex">
          <button class="toggle-btn" type="button">
            <i class="lni lni-grid-alt"></i>
          </button>
          <div class="sidebar-logo">
            <a href="#">Website Sell Phone</a>
          </div>
        </div>

        <ul class="sidebar-nav">
          <li class="sidebar-item">
            <a href="admin.html" class="sidebar-link">
              <i class="fa-solid fa-gauge"></i>
              <span>Dashboard</span>
            </a>
          </li>
          <li class="sidebar-item">
            <a href="MyStore.html" class="sidebar-link collapsed has-dropdown" data-bs-toggle="collapse"
               data-bs-target="#subMenu" aria-expanded="false" aria-controls="subMenu">
              <i class="fa-solid fa-store"></i>
              <span>My store</span>
            </a>
            <ul id="subMenu" class="sidebar-dropdown list-unstyled collapse" data-bs-parent="#sidebar">
              <li>
                <a href="${pageContext.request.contextPath}/admin/product-manage" class="sidebar-link ms-3">
                  <i class="fa-solid fa-box"></i>
                  <span>Product</span>
                </a>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/admin/category-manage" class="sidebar-link ms-3">
                  <i class="fa-solid fa-tags"></i>
                  <span>Category</span>
                </a>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/admin/order-manage" class="sidebar-link ms-3">
                  <i class="fa-solid fa-shopping-cart"></i>
                  <span>Order</span>
                </a>
              </li>
            </ul>
          </li>
          <li class="sidebar-item">
            <a href="#" class="sidebar-link">
              <i class="fa-solid fa-chart-pie"></i>
              <span>Analytics</span>
            </a>
          </li>
          <li class="sidebar-item">
            <a href="#" class="sidebar-link">
              <i class="fa-solid fa-message"></i>
              <span>Message</span>
            </a>
          </li>
          <li class="sidebar-item">
            <a href="${pageContext.request.contextPath}/admin/user-manage" class="sidebar-link">
              <i class="fa-solid fa-people-group"></i>
              <span>User</span>
            </a>
          </li>
          <li class="sidebar-item">
            <a href="#" class="sidebar-link">
              <i class="fa-solid fa-gear"></i>
              <span>Setting</span>
            </a>
          </li>
        </ul>
        <div class="sidebar-footer">
          <a href="#" class="sidebar-link">
            <i class="fa-solid fa-right-from-bracket"></i>
            <span>Log out</span>
          </a>
        </div>
      </aside>
      <!-- Main Content -->
      <main class="col-md-9 ms-sm-auto col-lg-10 px-md-5">
        <div
                class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          <h1 class="h2">My store</h1>
          <div class="btn-toolbar mb-2 mb-md-0">
            <div class="btn-group me-2">
              <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
              <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
            </div>
            <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
              <i class="bi bi-calendar"></i> This week
            </button>
          </div>
        </div>

        <div class="container-fluid mt-5">
          <h2 class="text-center">Thống kê sản phẩm bán chạy</h2>
          <canvas id="topProductsChart" width="400" height="200"></canvas>
        </div>


        <section id="product-management" class="mb-5">
          <h2>Product Management</h2>
          <form class="d-flex float-end" role="search">
            <input class="form-control me-2" type="search" placeholder="Search Products"
                   aria-label="Search" style="width: 300px;">
            <button class="btn btn-outline-primary" type="submit">Search</button>

          </form>
          <button class="btn btn-primary mb-3" data-bs-toggle="modal"
                  data-bs-target="#addProductModal">Add New Product</button>
          <table class="table table-striped">
            <thead>
            <tr>
              <th>ID</th>
              <th>Image</th>
              <th>Name</th>
              <th>Category</th>
              <th>Price</th>
              <th>Stock</th>
              <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1</td>
              <td><img src="data:image/jpeg;base64,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"
                       alt="Product Image" id="icon-product"></td>
              <td>Điện thoại iPhone 14</td>
              <td>Smartphone</td>
              <td>25,000,000 VND</td>
              <td>15</td>
              <td>
                <button class="btn btn-sm btn-warning">Edit</button>
                <button class="btn btn-sm btn-danger">Delete</button>
              </td>
            </tr>
            <tr>
              <td>2</td>
              <td><img src="https://cdn.tgdd.vn/Products/Images/42/249948/samsung-galaxy-s23-ultra-green-thumbnew-600x600.jpg"
                       alt="Product Image" id="icon-product"></td>
              <td>Samsung Galaxy S23</td>
              <td>Smartphone</td>
              <td>22,000,000 VND</td>
              <td>10</td>
              <td>
                <button class="btn btn-sm btn-warning">Edit</button>
                <button class="btn btn-sm btn-danger">Delete</button>
              </td>
            </tr>

            </tbody>
          </table>
        </section>

        <!-- Category Management Section -->


        <!-- Order Management Section -->

      </main>
    </div>
  </div>
</div>

<!-- Modals for Adding Product and Category -->
<!-- Add Product Modal -->
<div class="modal fade" id="addProductModal" tabindex="-1" aria-labelledby="addProductModalLabel"
     aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addProductModalLabel">Add New Product</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="productName" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="productName" required>
          </div>
          <div class="mb-3">
            <label for="productCategory" class="form-label">Category</label>
            <select class="form-select" id="productCategory" required>
              <option selected>Choose...</option>
              <option value="1">Smartphones</option>
              <option value="2">Accessories</option>
              <!-- More categories here -->
            </select>
          </div>
          <div class="mb-3">
            <label for="productPrice" class="form-label">Price</label>
            <input type="number" class="form-control" id="productPrice" required>
          </div>
          <div class="mb-3">
            <label for="productStock" class="form-label">Stock</label>
            <input type="number" class="form-control" id="productStock" required>
          </div>
          <button type="submit" class="btn btn-primary">Add Product</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Add Category Modal -->
<div class="modal fade" id="addCategoryModal" tabindex="-1" aria-labelledby="addCategoryModalLabel"
     aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addCategoryModalLabel">Add New Category</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="categoryName" class="form-label">Category Name</label>
            <input type="text" class="form-control" id="categoryName" required>
          </div>
          <button type="submit" class="btn btn-primary">Add Category</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Dashboard Overview -->

<!-- Charts -->


<!-- Product Management -->


<!-- Order Management -->


<!-- User Management -->

</main>
</div>




</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/views/js/Admin.js"></script>

<!-- data chart product -->
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const ctx = document.getElementById("topProductsChart").getContext("2d");

    // Dữ liệu ví dụ về tên sản phẩm và số lượng bán
    const productNames = ["Iphone 14", "Samsung s23"];
    const salesData = [150, 100]; // số lượng bán của mỗi sản phẩm

    // Tạo biểu đồ thanh
    const topProductsChart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: productNames,
        datasets: [
          {
            label: "Số lượng bán",
            data: salesData,
            backgroundColor: "rgba(54, 162, 235, 0.6)", // màu nền thanh biểu đồ
            borderColor: "rgba(54, 162, 235, 1)", // màu viền thanh biểu đồ
            borderWidth: 1,
          },
        ],
      },
      options: {
        responsive: true,
        scales: {
          y: {
            beginAtZero: true,
            title: {
              display: true,
              text: "Số lượng",
            },
          },
          x: {
            title: {
              display: true,
              text: "Tên sản phẩm",
            },
          },
        },
      },
    });
  });

</script>

</body>

</html>
