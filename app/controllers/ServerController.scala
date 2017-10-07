package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{Action, Controller}
import services.ServerService

import scala.concurrent.ExecutionContext

/**
  * Created by somveer on 29/8/17.
  */
@Singleton
class ServerController @Inject()(serverService: ServerService)
                                (implicit executionContext: ExecutionContext) extends Controller {

  def ping = Action {
    Ok("Server controller is up.")
  }

  def getServerInfo = Action.async {
    serverService.getServerInfo().map(response => Ok(response))
  }

  def getServerState = Action.async {
    serverService.getServerState().map(response => Ok(response))
  }

  def getConsensusInfo = Action.async {
    serverService.getConsensusInfo().map(response => Ok(response))
  }

  def getFetchInfo = Action.async {
    serverService.getFetchInfo().map(response => Ok(response))
  }

  def getFee = Action.async {
    serverService.getFee().map(response => Ok(response))
  }

}
