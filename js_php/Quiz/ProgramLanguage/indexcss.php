<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/stylecss.css">
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

                $p = "/adfile/css/$i.html";

                $file = file_get_contents($p);
                $nfile = cssn($file);

                echo $nfile;

                echo "<br>";
                echo "<label class = 'slabel'>Source Code: </label>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ydisplay'".">Show</button>";
                echo "<button class = 'code' type='button' onclick="."document.getElementsByTagName('div')[$i-101].className='ndisplay'".">Hide</button>";

                echo "<button class = 'code' type='button' onclick="."window.open('/adfile/css/$i.html')".">Apply CSS</button>";

                echo "<div>";
                    echo "<pre>".nl2br(htmlspecialchars($file))."</pre>";
                echo "</div>";

                echo "</li>";

                $i++;

            } while (file_exists("/adfile/css/$i.html"));

                function cssn($string) {
                    $string = str_replace("<style>", "<!--<style>", $string);
                    $string = str_replace("</style>", "</style>-->", $string);
                    return $string;
                }

        ?>

        </ol>

    <footer>

    </footer>

</body>
</html>
