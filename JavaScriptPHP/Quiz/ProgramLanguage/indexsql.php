<?php
  require("/config/config.php");
  require("/lib/db.php");
  $conn = conn_init($config['host'], $config['duser'], $config['dpw']);
  $conndb = conndb_init($config['host'], $config['duser'], $config['dpw'], $config['dname']);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/stylesql.css">
    <title>Social Activity</title>
</head>
<body>
    <header>
    </header>
        <ol>
        <?php
            $i = 101;
            do {
            $file = "/adfile/sql/$i.php";
            $data = file($file);
            $count = count($data);

            echo "<li>";
            echo "<div>";
            for ($p = 0; $p < 16; $p++) {
              echo "<p>".$data[$p]."</p>";
            }
            echo "</div>";

            echo "<label>Source Code: </label>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[2*($i-101)+1].className='ydisplay'".">Show</button>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[2*($i-101)+1].className='ndisplay'".">Hide</button>";


            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('em')[$i-101].className='yrun'".">Run</button>";

            echo "<div class ='ndisplay'>";
            for ($j = 16; $j < $count; $j++) {
              echo "<p>".$data[$j]."</p>";
            }
            echo "</div>";

            echo "<em>";
              $str = "";
              for ($k = 16; $k < $count; $k++) {
                $str = $str.$data[$k];
              }
              mysqli_query($conndb, $str);
            echo "</em>";

            echo "</li>";

            $i++;

          } while (file_exists("/adfile/sql/$i.php"));
        ?>
        </ol>
    <footer></footer>
</body>
</html>
