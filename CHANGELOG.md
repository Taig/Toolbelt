# Changelog

## 0.8.2

_2018-06-29_

 * Upgrade to monix 3.0.0-RC1
 
## 0.8.1

_2018-06-28_

 * Upgrade to rxjava2 2.1.16
 * Upgrade to play-services 15.0.1
 * Upgrade to cats 1.1.0

## 0.8.0

_2018-04-24_

 * Upgrade to rxjava2 2.1.12
 * Upgrade to android platform 27
 * Upgrade to play-services 15.0.0
 * Upgrade to rxjava 1.3.8

## 0.7.0

_2018-02-14_

 * Migrate to Fragment v4 (#5)

## 0.6.5

_2018-01-24_

 * Upgrade to rxjava 2.1.9
 * Upgrade to monix 2.3.3
 * Upgrade to sbt-scalafmt 1.15
 * Upgrade to play-services 11.8.0

## 0.6.4

_2017-12-15_

 *  Add SimpleTextWatcher
 *  Add mosby module
 *  Introduce scalafmt
 *  Upgrade to rxjava2 2.1.7
 *  Upgrade to rxjava 1.3.4
 *  Upgrade to scala 2.11.12
 *  Upgrade to play-services 11.6.2
 *  Upgrade to monix 2.3.2
 *  Upgrade to support-library 26.1.0
 *  Upgrade to sbt-android 1.7.10

## 0.6.3

_2017-11-16_

 * Upgrade to play-services 11.6.0

## 0.6.2

_2017-08-28_

 *  Upgrade to support-library 26.0.1
 *  Upgrade to play-services 11.2.0
 *  Upgrade to sbt-android 1.7.9

## 0.6.1

_2017-08-07_

 * Remove contract pattern helpers
 * Upgrade to platform-target 26
 * Upgrade to sbt-android 1.7.8
 * Upgrade to android support library 26.0.0
 * Upgrade to rxjava 2.1.2

## 0.6.0

_2017-06-20_

 * Remove custom lifecycle methods (wrapping `Bundle` as `Option[Bundle]`) in `Activity` and `Fragment`

## 0.5.26

_2017-05-11_

 * Replace custom Ui Executor with play services alternative (adds play-services dependency to `concurrent` module)
 * Upgrade to rxjava 1.3.0

## 0.5.25

_2017-05-09_

 * Add Observable EventSink feature
 * Upgrade to scala 2.11.11
 * Upgrade to sbt 0.13.15
 * Upgrade to sbt-android 1.7.7
 * Upgrade to android-25
 * Upgrade to android support library 25.3.1
 * Upgrade to play-services 10.2.4
 * Upgrade to monix 2.3.0
 * Upgrade to rxjava 1.2.10
 * Upgrade to rxjava2 2.1.0

## 0.5.24

_2017-03-13_

 * Upgrade to google play services 10.2.0
 * Upgrade to android support library 25.2.0

## 0.5.23

_2017-03-09_

 * Add RxJava2 support (`Observavle.fromRx2()`)

## 0.5.22

_2017-03-08_

 * Unsubscribe / disconnect from ActivityRecognition, Location updates and GoogleApiClient on Stop signal

## 0.5.21

_2017-03-01_

 * Upgrade to sbt-android 1.7.6
 * Introduce streamlined `Observable.locationUpdate`

## 0.5.20

_2017-02-20_

 * Improve GoogleApiClient Observable resource management
 * Upgrade to sbt-android 1.7.5

## 0.5.19

_2017-02-15_

 * Parametrize Reactive Dialog Action

## 0.5.18

_2017-01-31_

 * Upgrade to monix 2.2.1
 * Upgrade to sbt-android 1.7.4

## 0.5.17

_2017-01-27_

 *  Upgrade to rxjava 1.2.5
 *  Upgrade to sbt-android 1.7.3
 *  Upgrade to cats 0.9.0
 *  Upgrade to monix 2.2.0

## 0.5.16

_2017-01-12_

 * Experimental reactive Fragment for `monix.Observable`

## 0.5.15

_2016-12-21_

 * Add monix `Observable.fromRx` enrichment
 * Module monix no longer depends on module log
 * Upgrade to monix 2.1.2

## 0.5.14

_2016-12-19_

 * Upgrade to Android support library 25.1.0
 * Upgrade to play-services 10.0.1
 * Upgrade to monix 2.1.1
 * Upgrade to sbt-android 1.7.2

## 0.5.13

_2016-11-16_

 * Upgrade to Android support library 25.0.1
 * Upgrade to play-services 9.8.0

## 0.5.12

_2016-11-10_

 * Upgrade to cats 0.8.1
 * Upgrade to monix 2.1.0
 * Upgrade to sbt 0.13.13
 * Upgrade to sbt-android 1.7.1
 * Upgrade to sbt-scalariform 1.7.1

## 0.5.11

_2016-10-19_

 * Upgrade to sbt-android 1.7.0
 * Upgrade to monix 2.0.4
 * Distinguish between view.children & view.childrenRecusrive
 * Add graphic/Drawable.fromAttribute enrichment

## 0.5.10

_2016-09-19_

 * Improve monix module logging
 * Upgrade to monix 2.0.1
 * Upgrade to cats 0.7.2
 * Upgrade to Android support library 24.2.1

## 0.5.9

_2016-09-06_

 * Add new compat method Settings.canDrawOverlays

## 0.5.8

_2016-09-02_

 * Upgrade to monix 2.0.0
 * Upgrade to sbt-android 1.6.16

## 0.5.7

_2016-08-22_

 * New module: play-services
 * Upgrade to sbt-android 1.6.13
 * Upgrade to play-services 9.4.0
 * Upgrade to Android support library 24.2.0
 * Upgrade to monix 2.0-RC11
 * Upgrade to cats 0.7.0
 * Fix flawed `implicits` object in widget module

## 0.5.6

_2016-07-27_

 * Upgrade to Android support library 24.1.1

## 0.5.5

_2016-07-26_

 * Fix error in functional.flatMap (causing double executions)
 * Upgrade to sbt 0.13.12
 * Upgrade to sbt-android 1.6.9
 * Upgrade to cats 0.6.1

## 0.5.4

_2016-07-25_

 * Move `app.contract.Task` to `concurrent.app.contract.Job`

## 0.5.3

_2016-07-25_

 * Added compat.Configuration.locale

## 0.5.2

_2016-07-13_

 * Add compat.Html.fromHtml
 * Set platform and build target to 24
 * Upgrade to sbt-scalariform 1.7.0
 * Upgrade to sbt-sonatype 1.1.0
 * Upgrade to sbt-android 1.6.7

## 0.5.1

_2016-07-11_

 * Fix system service resolvers inferring `Nothing`

## 0.5.0

_2016-07-05_

 * Migration to multi-project build
 * Migration to monix.Task (from scala.concurrent.Future)
 * Modular project setup (from monolith to log, core, concurrent)
 * Upgrade to sbt-android 1.6.6