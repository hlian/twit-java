<!-- -*- mode: html -*- -->
<!doctype html>
<head>
  <title>twit</title>
  <meta charset="utf8">
  <meta content="IE=edge" http-equiv="X-UA-Compatible">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="${publicAt('css.css')}" rel="stylesheet">
</head>
<body>
  <main>
    <p><b>what up?</b></p>
    <form method="post" action="/api/tweets">
      <p><input name="tweet"><input type="submit" value="tweet"></p>
    </form>

    <p><b>tweets</b></p>

    <#list tweets as tweet>
      <p>##{tweet.id} ${tweet.tweet}</p>
    </#list>
  </main>
</body>
</html>
