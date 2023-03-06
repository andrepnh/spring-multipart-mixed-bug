#!/usr/bin/env sh

echo "Testing multipart requests with @RequestParam"
curl -H "Content-Type: multipart/mixed" \
  -F "json={\"name\": \"test\"};type=application/json" \
  -F "file=@dummy-file.txt" \
  http://localhost:8080/test/request-param
curl -H "Content-Type: multipart/form-data" \
  -F "json={\"name\": \"test\"};type=application/json" \
  -F "file=@dummy-file.txt" \
  http://localhost:8080/test/request-param

echo "Testing multipart requests with @RequestPart"
curl -H "Content-Type: multipart/mixed" \
  -F "json={\"name\": \"test\"};type=application/json" \
  -F "file=@dummy-file.txt" \
  http://localhost:8080/test/request-part
curl -H "Content-Type: multipart/form-data" \
  -F "json={\"name\": \"test\"};type=application/json" \
  -F "file=@dummy-file.txt" \
  http://localhost:8080/test/request-part

echo "Testing multipart requests with MultipartHttpServletRequest"
curl -H "Content-Type: multipart/mixed" \
  -F "json={\"name\": \"test\"};type=application/json" \
  -F "file=@dummy-file.txt" \
  http://localhost:8080/test/multipart-servlet-request
curl -H "Content-Type: multipart/form-data" \
  -F "json={\"name\": \"test\"};type=application/json" \
  -F "file=@dummy-file.txt" \
  http://localhost:8080/test/multipart-servlet-request

echo "Done"