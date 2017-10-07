package services

import com.google.inject.{ImplementedBy, Inject, Singleton}
import play.api.Logger
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by moglix on 29/8/17.
  */
@ImplementedBy(classOf[ServerServiceImpl])
trait ServerService {
  def getServerInfo() : Future[JsValue]
  def getServerState() : Future[JsValue]
  def getConsensusInfo() : Future[JsValue]
  def getFetchInfo() : Future[JsValue]
  def getFee() : Future[JsValue]
}

@Singleton
class ServerServiceImpl @Inject()(val genericService: GenericService)
                                (
                                  implicit wSClient: WSClient,
                                  executionContext: ExecutionContext
                                ) extends ServerService {

  private val logger: Logger = Logger(this.getClass)

  override def getServerInfo() : Future[JsValue] = {
    val body : JsValue = Json.obj("method"->"server_info")
    logger.debug(s"request body for server info is : ${body}")
    genericService.serverCall(body)
  }

  override def getServerState(): Future[JsValue] = {
    val body : JsValue = Json.obj("method"->"server_state")
    logger.debug(s"request body for server state is : ${body}")
    genericService.serverCall(body)
  }

  override def getConsensusInfo(): Future[JsValue] = {
    val body : JsValue = Json.obj("method"->"consensus_info")
    logger.debug(s"request body for consensus info is : ${body}")
    genericService.serverCall(body)
  }

  override def getFetchInfo(): Future[JsValue] = {
    val body : JsValue = Json.obj("method" -> "fetch_info") ++ Json.obj("params"->List(Json.obj("clear"->false)))
    logger.debug(s"request body for fetch info is : ${body}")
    genericService.serverCall(body)
  }

  override def getFee(): Future[JsValue] = {
    val body : JsValue = Json.obj("method" -> "fee")
    logger.debug(s"request body for get fee is : ${body}")
    genericService.serverCall(body)
  }

}
