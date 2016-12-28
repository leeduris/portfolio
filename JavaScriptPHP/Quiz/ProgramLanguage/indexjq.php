<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/stylejq.css">
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

                $p = "/adfile/jquery/$i.html";

                $file = file_get_contents($p);
                $nfile = jqcssn($file);

                echo $file;

                echo "<section>";
                echo "<label>Source Code: </label>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ydisplay'".">Show</button>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ndisplay'".">Hide</button>";
                echo "<button class = 'code' type ='button' onclick="."window.location.reload()".">Reload</button>";
                echo "</section>";

                echo "<div>";

                echo "<pre>".nl2br(htmlspecialchars($file))."</pre>";

                echo "</div>";

                echo "</li>";

                $i++;

            } while (file_exists('/adfile/jquery/'.$i.'.html'));

            function jqcssn($string) {
                $string = str_replace("<script", "<!--<script", $string);
                $string = str_replace("</script>", "</script>-->", $string);
                return $string;
            }

        ?>

        </ol>

    <footer></footer>

</body>
</html>
