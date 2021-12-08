<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>首页</title>
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <!-- General CSS Files -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.8.2/css/all.min.css">

  <!-- Template CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/iKuuuVPN/Frontend@e340f320ad70c07c6f2cafa5245eaed06006a58b/theme/malio/assets/css/style.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/iKuuuVPN/Frontend@e340f320ad70c07c6f2cafa5245eaed06006a58b/theme/malio/assets/css/components.css">

</head>

<body>
<div class="container mt-5">
  <div class="row">
    <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
      <div class="login-brand">
        <h1>图书管理系统</h1>
      </div>
      <div class="card card-primary">
        <div class="card-header">
          <h4>登录</h4>
        </div>
        <form action="${pageContext.request.contextPath}/user/login" method="POST" class="needs-validation" novalidate="">

          <div class="card-body">
            <div class="form-group login-form-item">
              <label for="name">用户名</label>
              <input id="name" type="text" class="form-control" name="name" value="${name}" tabindex="1" required="" autofocus="">
            </div>

            <div class="form-group login-form-item">
              <div class="d-block">
                <label for="password" class="control-label">密码</label>
              </div>
              <input id="password" type="password" class="form-control" name="password" value="${password}" tabindex="2" required="">

            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-primary btn-lg btn-block login" tabindex="4">
                登录
              </button>
            </div>
          </div></form>
      </div>
    </div>
  </div>
</div>

</body>
</html>