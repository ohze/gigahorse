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

final class StatusError(val status: Int, val text: String)
  extends RuntimeException("Unexpected status: " + status.toString + " " + text)
{
  def this(status: Int) = this(status, "")
  override def equals(o: Any): Boolean = o match {
    case x: StatusError => this.status == x.status && this.text == x.text
    case _ => false
  }
  override def hashCode: Int = {
    37 * (17 + status.##) + text.##
  }
}
object StatusError {
  def apply(status: Int): StatusError = new StatusError(status)
  def apply(status: Int, text: String): StatusError = new StatusError(status, text)
}
