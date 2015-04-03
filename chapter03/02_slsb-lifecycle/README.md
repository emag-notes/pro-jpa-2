# 02_slsb-lifecycle

``` sh
$ curl "localhost:8080/slsb-lifecycle/logger?message=foo"
please check server log

[server.log]
11:07:32,437 INFO  [notification] (default task-10) set up notification logger
11:07:32,437 INFO  [notification] (default task-10) foo
11:07:32,437 INFO  [notification] (default task-10) clean up!
```