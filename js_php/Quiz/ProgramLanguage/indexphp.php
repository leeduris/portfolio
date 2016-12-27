<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/stylephp.css">
    <title>Social Activity</title>
</head>
<body>
    <header>

    </header>

    <article>

        <ol>

        <?php
            $i = 101;
            do {
            $file = "/adfile/php/$i.php";
            echo "<li>";

            echo strip_tags(file_get_contents($file),'<h1>');

            echo "<label>Source Code: </label>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ydisplay'".">Show</button>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ndisplay'".">Hide</button>";

            echo "<div>";
                echo "<pre>".nl2br(htmlspecialchars(file_get_contents($file)))."</pre>";
            echo "</div>";

            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('em')[$i-101].className='yrun'".">Run</button>";

            echo "<em>";
                $data = file("http://localhost/w3Tutorials/adfile/php/$i.php");
                foreach($data as $val) {
                echo "<p>".strip_tags($val)."</p>";
                }
            echo "</em>";

            echo "</li>";

            $i++;

          } while (file_exists("/adfile/php/$i.php"));
        ?>


        </ol>

    </article>

    <footer>

    </footer>

</body>
</html>
