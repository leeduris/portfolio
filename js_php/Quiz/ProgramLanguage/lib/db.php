<?php
  function conn_init($host, $duser, $dpw) {
      $conn = mysqli_connect($host, $duser, $dpw);
      return $conn;
  }

  function conndb_init($host, $duser, $dpw, $dname) {
      $conn = mysqli_connect($host, $duser, $dpw);
      mysqli_select_db($conn, $dname);
      return $conn;
  }
?>
