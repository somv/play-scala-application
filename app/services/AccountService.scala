package services

import com.google.inject.{ImplementedBy, Inject, Singleton}
import play.api.Logger
import play.api.libs.json.{JsValue, Json}

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by moglix on 1/9/17.
  */
@ImplementedBy(classOf[AccountServiceImpl])
trait AccountService {
  def getAccountCurrencies(body:JsValue) : Future[JsValue]
  def getAccountChannals(body:JsValue) : Future[JsValue]
  def getAccountInfo(body:JsValue) : Future[JsValue]
  def getAccountLines(body:JsValue) : Future[JsValue]
  def getAccountOffers(body:JsValue) : Future[JsValue]
  def getAccountObjects(body:JsValue) : Future[JsValue]
  def getAccountTx(body:JsValue) : Future[JsValue]
  def noRippleCheck(body:JsValue) : Future[JsValue]
  def gatewayBalances(body:JsValue) : Future[JsValue]
  def walletPropose(body:JsValue) : Future[JsValue]
}

@Singleton
class AccountServiceImpl @Inject()(val genericService: GenericService)(implicit executionContext: ExecutionContext) extends AccountService {

  private val logger = Logger(this.getClass)

  override def getAccountCurrencies(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def getAccountChannals(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def getAccountInfo(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def getAccountLines(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def getAccountOffers(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def getAccountObjects(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def getAccountTx(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def noRippleCheck(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def gatewayBalances(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

  override def walletPropose(body: JsValue): Future[JsValue] = {
    logger.debug(s"Request body is : ${body}")
    genericService.serverCall(body)
  }

}
