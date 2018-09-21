package mockit.asm;

import javax.annotation.*;

final class HostClassWriter extends AttributeWriter
{
   @Nonnegative private final int hostClassNameIndex;

   HostClassWriter(@Nonnull ConstantPoolGeneration cp, @Nonnull String hostClassName) {
      super(cp, "NestHost");
      hostClassNameIndex = cp.newClass(hostClassName);
   }

   @Nonnegative @Override
   int getSize() { return 8; }

   @Override
   void put(@Nonnull ByteVector out) {
      super.put(out);
      out.putShort(hostClassNameIndex);
   }
}
