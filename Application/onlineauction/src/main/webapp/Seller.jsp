<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sellers Page</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <link href="/your-path-to-fontawesome/css/fontawesome.css" rel="stylesheet">
  <!-- Favicons -->
  <link href="../images/favicon.png" rel="icon">
  <link href="../images/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link
    href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
    rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="./vendor/aos/aos.css" rel="stylesheet">
  <link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="./vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="./vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="./vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="./vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="./vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="./css/seller.css" rel="stylesheet">
  <link href="./css/style.css" rel="stylesheet">
<script type="text/javascript">
        function redirect(){
        window.location = "/GlobalServlet?ac=displayseller"
        }
</script>
	
</head>

<body onLoad="redirect()">
  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

      <div class="logo">
        <h1> <a href="index.html"><img src="../images/logo.png" alt="" class="img-fluid"></a><a href="index.html">
            TechAmigas</a> </h1>


      </div>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto" href="index.html#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="index.html#about">About</a></li>
          <ul>
            <li><a class="nav-link scrollto" href="index.html#contact">Contact</a></li>
            <li><a class="nav-link scrollto">
                <div class="input-group rounded">
                  <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
                    aria-describedby="search-addon" />
                  <span class="input-group-text border-0" id="search-addon">
                    <i class="bi bi-search"></i>
                  </span>
                </div>
              </a></li>
          </ul>
          <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
    </div>
    
  </header>

  <section class="one">
    <div class="wrapper">
      <div class="left">
        <img src="../images/profileimage.png" alt="user" width="100">
        <h4 class="name">Issac</h4>
      </div>
      <div class="right">
        <div class="info">
         
          <div class="info-data">
            <div class="data">
              <h4>Email</h4>
    			 <h3>issac@gmail.com</h3>
            </div>
            <div class="data">
              <h4>Last logged in</h4>
              <p class="phone">$</p>
              <h3>8340867890</h3>
            </div>
          </div>
        </div>
        <div class="info2">
          <h3>Wallet Information</h3>
          <div class="info-data2">
            <div class="data2">
              <h4>Wallet Cash</h4>
              <p class="wallet-cash">40000</p>
            </div>
            <!-- <div class="data">
                            <h4>Phone</h4>
                            <p class="phone">9999988888</p>
                        </div> -->
          </div>
        </div>
      </div>
    </div>
  </section>

  <div class="card__info">
      
            <div>
              <a href=AddPro.html>+Add product</a>
            </div>
          </div>
          <div class="card__info">
              
            <div>
              <a href=scheduleauction.html>+Scheduletime</a>
            </div>
          </div>

  <section class="two">
    <div class="product-list">
      <table>
        <thead>
          <tr>
            <th>Product name</th>
            <th>Highest Current Bid</th>
            <th>Number of Bidders</th>
            <th>Bid End Date</th>
            <th>Image</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody id="tableData"></tbody>
        <img src="../tableImages/" alt="" srcset="">
      </table>
    </div>
  </section>

  <div class="clear"></div>
  <!-- ======= Footer ======= -->
  <footer id="footer">
    <div class="container">
      <div class="row d-flex align-items-center">
        <div class="col-lg-6 text-lg-left text-center">
          <div class="copyright">
            &copy; Copyright <strong>Vesperr</strong>. All Rights Reserved
          </div>
          <div class="credits">
            <!-- All the links in the footer should remain intact. -->
            <!-- You can delete the links only if you purchased the pro version. -->
            <!-- Licensing information: https://bootstrapmade.com/license/ -->
            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/vesperr-free-bootstrap-template/ -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
          </div>
        </div>
        <div class="col-lg-6">
          <nav class="footer-links text-lg-right text-center pt-2 pt-lg-0">
            <a href="#intro" class="scrollto">Home</a>
            <a href="#about" class="scrollto">About</a>
            <a href="#">Privacy Policy</a>
            <a href="#">Terms of Use</a>
          </nav>
        </div>
      </div>
    </div>
  </footer><!-- End Footer -->
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
      class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="./vendor/aos/aos.js"></script>
  <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="./vendor/glightbox/js/glightbox.min.js"></script>
  <script src="./vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="./vendor/php-email-form/validate.js"></script>
  <script src="./vendor/purecounter/purecounter.js"></script>
  <script src="./vendor/swiper/swiper-bundle.min.js"></script>

  <!-- Template Main JS File -->
  <!--   <script src="../js/main.js"></script> -->
  <!--      <script src="../js/buyer.js"></script> -->

  <!-- <img class="big-circle" src="../images/big-eclipse.svg" alt="" />
        <img class="medium-circle" src="../images/mid-eclipse.svg" alt="" />
        <img class="small-circle" src="../images/small-eclipse.svg" alt="" /> -->
  </div>
  <script src="./js/seller.js"></script>

</body>

</html>