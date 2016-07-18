package controllers

import javax.inject.Inject
import play.api.mvc._
import play.api.i18n.I18nSupport 
import play.api.i18n.MessagesApi
import javax.inject._

import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc._
import play.api._

import play.api.test._

import java.io.{FileWriter, FileOutputStream, File}

import controllers._
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart

import java.io.File

import java.nio.file.attribute.PosixFilePermission._
import java.nio.file.attribute.PosixFilePermissions
import java.nio.file.{Files, Path}
import java.nio.file.Paths
import java.util
import javax.inject._

import akka.stream.IOResult
import akka.stream.scaladsl._
import akka.util.ByteString
import akka.actor._
import akka.stream.Materializer



import play.api.libs.streams._
import play.api.mvc.MultipartFormData.FilePart

import play.api.libs.streams.Accumulator

import play.api.mvc.BodyParsers.parse

import play.api.mvc.BodyParsers.parse._
import play.core.parsers.Multipart.FileInfo
import scala.concurrent.Future

import java.io.ByteArrayOutputStream

import play.api.libs.iteratee.Iteratee

import play.api.mvc.BodyParsers.parse._

import play.api.mvc.{BodyParser, MultipartFormData}

import scala.concurrent.ExecutionContext.Implicits.global

import play.core.parsers.Multipart

import play.api.mvc.BodyParsers.parse.multipartFormData

import play.api.libs.streams._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import akka.util.ByteString
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import akka.actor._
import akka.stream.Materializer
import play.api.mvc.Result

import java.nio.file.attribute.BasicFileAttributes
import akka.stream.scaladsl.{FileIO, Sink}
import akka.stream.scaladsl.FileIO
import java.nio.file.StandardOpenOption

class UploadController @Inject() (implicit val mat: Materializer, system: ActorSystem,val messagesApi:MessagesApi) extends Controller with I18nSupport{
    
    type FilePartHandler[A] = FileInfo => Accumulator[ByteString, FilePart[A]]

    def handleFilePartAsFile: FilePartHandler[File] = {
     
    
    case FileInfo(partName, filename, contentType) =>
       
        val filepath = Paths.get("/home/mjkam/workspace/factorials")
        val filesink :Sink[ByteString, Future[IOResult]] =FileIO.toPath(filepath,Set(StandardOpenOption.CREATE_NEW,StandardOpenOption.WRITE))
        val accumulator = Accumulator(filesink)
   
        accumulator.map { case IOResult(count, status) =>
          Logger.debug(status.toString())
          FilePart(partName, filename, contentType, filepath.toFile())
        }(play.api.libs.concurrent.Execution.defaultContext)
    }

      
      def uploadCustom = Action(parse.multipartFormData(handleFilePartAsFile,1000000000000L)) { request =>
              
        Ok("finish")
      }
}