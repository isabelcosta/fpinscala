# Listing 8.1

This is the clean result out of testing the listing 8.1.

```
➜  fpinscala git:(solving-exercises) ✗ cd exercises/src/test/scala 
➜  exercises git:(solving-exercises) ✗ cd ..
➜  fpinscala git:(solving-exercises) ✗ sbt
[info] Loading project definition from /Users/isabelcosta/dev/learn/fpinscala/project
[info] Set current project to fpinscala (in build file:/Users/isabelcosta/dev/learn/fpinscala/)
> project exercises
[info] Set current project to exercises (in build file:/Users/isabelcosta/dev/learn/fpinscala/)

> test:console
[info] Compiling 3 Scala sources to /Users/isabelcosta/dev/learn/fpinscala/exercises/target/scala-2.12/test-classes...
[warn] /Users/isabelcosta/dev/learn/fpinscala/exercises/src/test/scala/fpinscala/testing/ListSpecification.scala:4: imported `Gen' is permanently hidden by definition of object Gen in package testing
[warn] import org.scalacheck.Gen
[warn]                       ^
[warn] one warning found
[info] Starting scala interpreter...
[info] 
Welcome to Scala 2.12.1 (OpenJDK 64-Bit Server VM, Java 1.8.0_232).
Type in expressions for evaluation. Or try :help.

scala> import org.scalacheck.Gen
import org.scalacheck.Gen

scala> val intList = Gen.listOf(Gen.choose(0,100))
intList: org.scalacheck.Gen[List[Int]] = org.scalacheck.Gen$$anon$1@64d8c0a9

scala> import org.scalacheck.Prop.forAll
import org.scalacheck.Prop.forAll

scala> val prop = forAll(intList)(ns => ns.reverse.reverse == ns) && forAll(intList)(ns => ns.headOption == ns.reverse.lastOption)
prop: org.scalacheck.Prop = Prop

scala> val failingProp = forAll(intList)(ns => ns.reverse == ns)
failingProp: org.scalacheck.Prop = Prop

scala> prop.check
+ OK, passed 100 tests.

scala> failingProp.check
! Falsified after 4 passed tests.
> ARG_0: List("0", "1")
> ARG_0_ORIGINAL: List("20", "48", "59")

scala> 
```