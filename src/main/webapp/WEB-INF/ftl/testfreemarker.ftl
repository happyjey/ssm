<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<h1>testfreemarker.html</h1>
${content}
<hr />
<#list ['a', 'b', 'c'] as x>
    ${x?index}:${x}<br>
</#list>
</body>
</html>