package services

import java.io.IOException
import javax.inject.Inject

import com.google.inject.{ImplementedBy, Singleton}
import play.api.Logger
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

/**
  * Created by moglix on 29/8/17.
  */
@ImplementedBy(classOf[GenericServiceImpl])
trait GenericService {
  def serverCall(body : JsValue) : Future[JsValue]
}

@Singleton
class GenericServiceImpl @Inject()(implicit wSClient: WSClient,
                                   executionContext: ExecutionContext) extends GenericService {

  private val logger: Logger = Logger(this.getClass)

  override def serverCall(body: JsValue): Future[JsValue] = {
    var res: JsValue=Json.obj()
    val fut = wSClient.url("http://s1.ripple.com:51234")
      .post(body)
      .map{
        response=>
          if(response.status<300) Json.obj("status_code"->response.status, "status_text"->response.statusText, "body"->response.json)
          else Json.obj("status_code"->response.status, "status_text"->response.statusText, "body"->response.body)
      }
    fut
  }

}
