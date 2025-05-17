const https = require('https');

// !!! PUT YOUR API KEY HERE !!!
const api_key = 'YOUR_API_KEY';

if (process.argv.length !== 3) {
    console.log(`usage: node ${process.argv[1]} <email>`);
    process.exit(1);
}

const email = process.argv[2];

https.get(`https://api.millionverifier.com/api/v3/?api=${api_key}&email=${email}`, (res) => {
    let data = '';
    res.on('data', chunk => {
        data += chunk;
    });
    res.on('end', () => {
        try {
            const j = JSON.parse(data);
            const c = j.resultcode;
            switch (c) {
                case 1:
                    console.log('Ok');
                    break;
                case 2:
                    console.log('Catch All');
                    break;
                case 3:
                    console.log('Unknown');
                    break;
                case 4:
                    console.log('Error: ' + j.error);
                    break;
                case 5:
                    console.log('Disposable');
                    break;
                case 6:
                    console.log('Invlaid');
                    break;
            }
        } catch (e) {
            console.error('Failed to parse response');
        }
    });
}).on('error', (err) => {
    console.log('Error: ' + err.message);
});
