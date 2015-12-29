package libs

import play.api.mvc.RequestHeader

class PjaxHeader(val isPjax: Boolean)

trait PjaxSupport {

  protected val headerName: String = "X-PJAX"

  implicit final def request2pjax(implicit request: RequestHeader): PjaxHeader = new PjaxHeader(request.headers.keys(headerName))
}
