# 03_sfsb

``` sh
$ curl localhost:8080/sfsb/shopping-cart                            
{}

$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=add&item=foo&quantity=3"
$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=add&item=bar&quantity=2"
$ curl localhost:8080/sfsb/shopping-cart
{bar=2, foo=3}

$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=remove&item=foo&quantity=1"
$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=remove&item=bar&quantity=99"
$ curl localhost:8080/sfsb/shopping-cart
{foo=2}

$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=checkout"

$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=cancel"
```