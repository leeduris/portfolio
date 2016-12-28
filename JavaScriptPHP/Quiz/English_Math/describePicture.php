<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/styleeh.css">
    <title>Social Activity</title>
</head>
<body>
    <header>
    </header>
        <ol>
        <?php
            $i = 101;
            do {
              $image = "/image/eh/$i.jpg";
              $file = "/adfile/eh/$i.txt";
              $data = file($file);
              $count = count($data);

              echo "<li>";
              echo "<p>".$data[1]."</p>";

              if ($data[0] == 2) {
                echo  "<p><img src = $image></p>";
              }
              else if ($data[0] == 6) {
                echo "<section>";
                for ($p = 2; $p < 16; $p++)
                  echo "<p class = 'pro'>".$data[$p]."</p>";
                echo "</section>";
              }
              else if ($data[0] == 15) {
                echo  "<p>$data[2]</p>";
                echo  "<p>$data[3]</p>";
              }

              echo "<label>Sentences: </label>";
              echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ydisplay'".">Show</button>";
              echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ndisplay'".">Hide</button>";

              echo "<div>";
              echo "<hr>";
              for ($p = 16; $p < $count; $p++) {
                echo "<p  class = 'sol'>".$data[$p]."</p>";
              }
              echo "<hr>";
              echo "</div>";

              echo "</li>";

              $i++;

          } while (file_exists("/adfile/eh/$i.txt"));
        ?>
        </ol>
    <footer></footer>
</body>
</html>
