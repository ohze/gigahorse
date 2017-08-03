/*
 * Copyright 2016 by Eugene Yokota
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gigahorse
package support.okhttp

import okhttp3.Headers

abstract class OkhCompletionHandler[A] extends CompletionHandler[A] with OkhHandler {
  def onStatusReceived(status: Int, text: String): Unit = ()
  def onHeadersReceived(headers: Headers): Unit = ()
  def onCompleted(response: FullResponse): A
}
