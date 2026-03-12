// commonJs 방식
const c = require('ansi-colors');

// node_modules
// 프로젝트에서 사용하는 모든 npm 패키지가 저장되는 디렉토리

//
//

function hello(name) {
    console.log(c.green(name) + ' 님 안녕하세요');
}

hello('홍길동');
