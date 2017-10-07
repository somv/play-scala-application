package controllers

import com.google.inject.{Inject, Singleton}
import play.api.Logger
import play.api.mvc.{Action, Controller}
import services.AccountService

import scala.concurrent.ExecutionContext

/**
  * Created by moglix on 1/9/17.
  */
@Singleton
class AccountController @Inject()(accountService: AccountService)
                                 (implicit executionContext: ExecutionContext) extends Controller {

  private val logger = Logger(this.getClass)

  def ping = Action {
    Ok("Account controller looks fine")
  }

  def getAccountCurrencies() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.getAccountCurrencies(request.body).map(response=>Ok(response))
  }

  def getAccountChannals() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.getAccountChannals(request.body).map(response=>Ok(response))
  }

  def getAccountInfo() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.getAccountInfo(request.body).map(response=>Ok(response))
  }

  def getAccountLines() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.getAccountLines(request.body).map(response=>Ok(response))
  }

  def getAccountOffers() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.getAccountOffers(request.body).map(response=>Ok(response))
  }

  def getAccountObjects() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.getAccountObjects(request.body).map(response=>Ok(response))
  }

  def getAccountTx() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.getAccountTx(request.body).map(response=>Ok(response))
  }

  def noRippleCheck() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.noRippleCheck(request.body).map(response=>Ok(response))
  }

  def gatewayBalances() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.gatewayBalances(request.body).map(response=>Ok(response))
  }

  def walletPropose() = Action.async(parse.json) { implicit request=>
    logger.info(s"Request body is : ${request.body}")
    accountService.walletPropose(request.body).map(response=>Ok(response))
  }

}
