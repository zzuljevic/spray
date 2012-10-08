package cc.spray.routing

import akka.dispatch.Future

sealed trait RequestResult
object RequestResult {
  implicit def futureReqResultIsReqResult(f: Future[RequestResult]): RequestResult = null

  val NotCompletedHere: RequestResult = null
  implicit def canThrowAwayResultIsFunctionToUnit[T](route: T => RequestResult): T => Unit = ctx => route(ctx)
}