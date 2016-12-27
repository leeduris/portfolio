<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/stylejava.css">
    <title>Social Activity</title>
</head>
<body>
    <header>

    </header>

        <ol reversed="reversed">

        <?php
            $directory = "/adfile/java/";
            $i = count(glob($directory ."*.java")) + 100;
            $k=1;
            do {
                echo "<li>";

                $qfile = file_get_contents("/adfile/java/Q$i.txt");
                $jfile = file_get_contents("/adfile/java/J$i.java");
                $rfile = file_get_contents("/adfile/java/R$i.txt");
                $efile = file("/adfile/java/ideone.txt");

                echo "<div class = 'question'>";
                echo nl2br($qfile);
                echo "</div>";

                echo "<section>";
                echo "<label>Source Codes: </label>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[3*($k-1)+1].className='yjdisplay'".">Show</button>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[3*($k-1)+1].className='njdisplay'".">Hide</button>";
                echo "</section>";

                echo "<div>";
                echo "<pre>".nl2br(htmlspecialchars($jfile))."</pre>";
                echo "</div>";

                echo "<section>";
                echo "<label>View Console: </label>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[3*($k-1)+2].className='yrdisplay'".">Show</button>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[3*($k-1)+2].className='nrdisplay'".">Hide</button>";
              //echo "<button class = 'code' type='button' onclick="."window.open".$efile[$i-101].">Execute</button>";
                echo "</section>";

                echo "<div>";
                echo nl2br(htmlspecialchars($rfile));
                echo "</div>";

                echo "</li>";

                $i--;
                $k++;

            } while (file_exists('/adfile/java/J'.$i.'.java'));

        ?>

        </ol>

    <footer></footer>

</body>
</html>
