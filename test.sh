#!/usr/bin/env bash
echo 'Compiling and running tests'
lein with-profile +test run -m shadow.cljs.devtools.cli --npm compile node
