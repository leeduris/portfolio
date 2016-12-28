<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/stylehtml.css">
    <title>Social Activity</title>
</head>
<body>
    <header>

    </header>


        <ol>
        <?php
            $i = 101;
            do {
            echo "<li>";

            echo "<div class = 'cont'>";
            echo file_get_contents("/adfile/html/$i.html");
            echo "</div>";

            echo "<label class = 'slabel'>Source Code: </label>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[($i-101)*2+1].className='ydisplay'".">Show</button>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[($i-101)*2+1].className='ndisplay'".">Hide</button>";

            echo "<div>";
            echo "<pre class = 'mpre'>".nl2br(htmlspecialchars(file_get_contents("/adfile/html/$i.html")))."</pre>";
            echo "</div>";

            echo "</li>";

            $i++;

          } while (file_exists("/adfile/html/$i.html"));
        ?>
        </ol>


    <footer>

    </footer>

</script>
</body>
</html>
