<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/stylejs.css">
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

            echo file_get_contents('/adfile/javaScript/'.$i.'.html');

            echo "<label>Source Code: </label>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ydisplay'".">Show</button>";
            echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ndisplay'".">Hide</button>";

            echo "<div>";

            echo "<pre>".nl2br(htmlspecialchars(file_get_contents('/adfile/javaScript/'.$i.'.html')))."</pre>";

            echo "</div>";

            echo "</li>";

            $i++;

          } while (file_exists('/adfile/javaScript/'.$i.'.html'));
        ?>
        </ol>

    <footer>
    </footer>

</body>
</html>
