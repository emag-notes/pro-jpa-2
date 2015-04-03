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
```

``` sh
$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=checkout"
```

or

``` sh
$ curl -X POST "localhost:8080/sfsb/shopping-cart?action=cancel"
```

``` sh
[server.log]
ERROR [org.jboss.as.ejb3.invocation] (default task-46) JBAS014134
: EJB Invocation failed on component ShoppingCart for method public java.util.Map projpa2.ejb.ShoppingCart.getItems()
: javax.ejb.NoSuchEJBException: JBAS014300: Could not find EJB with id {[-59, 37, 118, -86, 93, 19, 73, 105, -102, 14, 24, -121, 3, -119, 94, -57]}
```