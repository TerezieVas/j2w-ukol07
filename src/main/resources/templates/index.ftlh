[#ftl]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Můj blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="icon" type="image/png" href="/images/favicon.png">
</head>
<body>
<h1>Různé články</h1>
[#list seznam.content as post]
    <a href="/post${post.slug}">
        <div class="vizitka">
            <div class="jmeno">${post.title}</div>
            <div class="udaje">${post.perex?no_esc}</div>

        </div>
    </a>
[/#list]
</body>
</html>