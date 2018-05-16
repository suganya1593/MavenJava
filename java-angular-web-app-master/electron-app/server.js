
var express = require('express');
var app = express();
const args = process.argv;

var port=args[2];
 
app.set('port', port);
app.use(express.static(__dirname+'/../frontend-app/dist'));
 

app.get('/', function (req, res) {
  res.send('Hello World!');
});

app.listen(app.get('port'), function () {
  console.log('Example app listening on port '+app.get('port'));
});